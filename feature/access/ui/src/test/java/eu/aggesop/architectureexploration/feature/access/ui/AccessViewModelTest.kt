package eu.aggesop.architectureexploration.feature.access.ui

import eu.aggesop.architectureexploration.feature.access.domain.model.AccessLockState
import eu.aggesop.architectureexploration.feature.access.domain.usecase.GetLockStateUseCase
import eu.aggesop.architectureexploration.feature.access.domain.usecase.LockVehicleUseCase
import eu.aggesop.architectureexploration.feature.access.domain.usecase.UnlockVehicleUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class AccessViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private val getLockStateUseCase: GetLockStateUseCase = mockk()
    private val lockVehicleUseCase: LockVehicleUseCase = mockk()
    private val unlockVehicleUseCase: UnlockVehicleUseCase = mockk()

    private lateinit var viewModel: AccessViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        every { getLockStateUseCase() } returns flowOf(AccessLockState.LOCKED)
        viewModel = AccessViewModel(getLockStateUseCase, lockVehicleUseCase, unlockVehicleUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `initial state is locked`() = runTest {
        advanceUntilIdle()
        assertEquals(AccessLockState.LOCKED, viewModel.state.value.lockState)
    }

    @Test
    fun `toggleLock when locked calls unlockVehicleUseCase`() = runTest {
        coEvery { unlockVehicleUseCase() } returns Unit
        
        viewModel.toggleLock()
        advanceUntilIdle()
        
        coVerify { unlockVehicleUseCase() }
    }

    @Test
    fun `toggleLock when unlocked calls lockVehicleUseCase`() = runTest {
        // Prepare unlocked state
        every { getLockStateUseCase() } returns flowOf(AccessLockState.UNLOCKED)
        val unlockedViewModel = AccessViewModel(getLockStateUseCase, lockVehicleUseCase, unlockVehicleUseCase)
        advanceUntilIdle()
        
        coEvery { lockVehicleUseCase() } returns Unit
        
        unlockedViewModel.toggleLock()
        advanceUntilIdle()
        
        coVerify { lockVehicleUseCase() }
    }
}

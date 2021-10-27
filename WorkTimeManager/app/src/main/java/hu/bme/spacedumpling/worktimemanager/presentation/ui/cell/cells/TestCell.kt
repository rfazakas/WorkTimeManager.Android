package hu.bme.spacedumpling.worktimemanager.presentation.ui.cell.cells

import androidx.core.content.ContextCompat
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import hu.bitraptors.recyclerview.genericlist.GenericListItem
import hu.bme.spacedumpling.worktimemanager.databinding.CellTestBinding
import hu.bme.spacedumpling.worktimemanager.presentation.ui.cell.presentationmodels.TestItem
import kotlinx.coroutines.flow.MutableSharedFlow

fun testDelegate(callback: MutableSharedFlow<Any>) =
    adapterDelegateViewBinding<TestItem, GenericListItem, CellTestBinding>(
        viewBinding = { layoutInflater, root ->
            CellTestBinding.inflate(layoutInflater, root, false)
        },
        block = {
            bind {
                binding.testIcon.setImageDrawable(ContextCompat.getDrawable(context, item.icon))
                binding.testText.text = item.title
                binding.root.setOnClickListener { callback.tryEmit(item) }
            }
        }
    )
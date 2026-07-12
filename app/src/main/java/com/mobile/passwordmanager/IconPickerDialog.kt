package com.mobile.passwordmanager

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.mobile.passwordmanager.databinding.DialogIconPickerBinding

/**
 * 弹出图标选择器,让用户从离线品牌图标库(Simple Icons)中挑一个,用于分组或密码条目。
 * [currentKey] 是当前已选的图标标识(可为空)。点击某个图标即完成选择并关闭弹窗,
 * 通过 [onPicked] 回调新的 key;点击"清除图标"则回调 null。
 */
object IconPickerDialog {

    fun show(context: Context, currentKey: String?, onPicked: (String?) -> Unit) {
        val binding = DialogIconPickerBinding.inflate(LayoutInflater.from(context))

        lateinit var dialog: androidx.appcompat.app.AlertDialog

        val adapter = IconPickerAdapter { entry ->
            onPicked(entry?.key)
            dialog.dismiss()
        }
        adapter.setSelected(currentKey)

        binding.recyclerIcons.layoutManager = GridLayoutManager(context, 4)
        binding.recyclerIcons.adapter = adapter

        binding.etIconSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                val results = IconCatalog.search(s?.toString().orEmpty())
                adapter.submit(results)
                adapter.setSelected(currentKey)
                binding.tvIconEmpty.visibility = if (results.isEmpty()) View.VISIBLE else View.GONE
            }
        })

        dialog = MaterialAlertDialogBuilder(context)
            .setTitle(R.string.dialog_pick_icon)
            .setView(binding.root)
            .setNegativeButton(R.string.cancel, null)
            .setNeutralButton(R.string.icon_clear) { _, _ ->
                onPicked(null)
            }
            .create()

        dialog.show()
    }
}

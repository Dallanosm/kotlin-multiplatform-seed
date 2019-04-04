package com.mpp.seed.android.permission

import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener

class TaxiPermissionListener(
    private val onGranted: () -> Unit = {},
    private val onRationale: (PermissionToken) -> Unit = {},
    private val onDenied: () -> Unit = {}
) : MultiplePermissionsListener {

    override fun onPermissionRationaleShouldBeShown(
        permissions: MutableList<PermissionRequest>?,
        token: PermissionToken?
    ) {
        if (token != null) {
            onRationale(token)
        }
    }

    override fun onPermissionsChecked(report: MultiplePermissionsReport?) {
        report?.let {
            if (it.areAllPermissionsGranted()) {
                onGranted()
            } else {
                onDenied()
            }
        }
    }
}
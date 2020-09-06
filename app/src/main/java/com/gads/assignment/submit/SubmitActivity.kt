package com.gads.assignment.submit

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.gads.assignment.R
import com.gads.assignment.api.SubmissionService
import kotlinx.android.synthetic.main.activity_submit.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SubmitActivity : AppCompatActivity(R.layout.activity_submit) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
    }

    fun submitProject(view: View) {
        val fname = firstName.text.toString()
        val sname = secondName.text.toString()
        val email = email.text.toString()
        val ghLink = githubLink.text.toString()
        if (fname.isNotEmpty() && sname.isNotEmpty() && email.isNotEmpty() && ghLink.isNotEmpty()) {
            SubmissionService
                .create()
                .submitProject(
                    firstName = fname,
                    lastName = sname,
                    email = email,
                    githubLink = ghLink
                )
                .enqueue(object : Callback<Unit> {
                    override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                        if (response.isSuccessful) {
                            createSuccessDialog().show()
                        } else {
                            createErrorDialog().show()
                        }
                    }

                    override fun onFailure(call: Call<Unit>, t: Throwable) {
                        Log.e("Submission Error", "$t")
                        createErrorDialog().show()
                    }

                })
        } else {
            Toast.makeText(this, "All fields must be filled", Toast.LENGTH_LONG).show()
        }
    }

    private fun createSuccessDialog(): AlertDialog {
        return AlertDialog.Builder(this@SubmitActivity)
            .setMessage("Submission Successful")
            .setIcon(R.drawable.ic_baseline_check_circle_24)
            .create()
    }

    private fun createErrorDialog(): AlertDialog {
        return AlertDialog.Builder(this@SubmitActivity)
            .setIcon(R.drawable.ic_baseline_warning_24)
            .setMessage("Submission Not Successful")
            .create()
    }

}

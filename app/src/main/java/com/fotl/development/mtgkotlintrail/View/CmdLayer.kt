package com.fotl.development.mtgkotlintrail.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import androidx.fragment.app.Fragment

import com.fotl.development.mtgkotlintrail.R

class CmdLayer : Fragment() {

    // Members / Fields
    // Var vs Val declaration:
    // Var is known as a mutable variable
    // Val is like Final
    private var tv_lifeTotal: TextView? = null
    private var curLife: String? = null
    private var newLiTl: Int? = null
    private var tv_Cmd: TextView? = null
    private var curCmd: String? = null
    private var tv_inf: TextView? = null
    private var curInf: String? = null

    private var hideCmdView: TextView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        (activity as AppCompatActivity).supportActionBar!!.hide()


        return inflater.inflate(R.layout.fragment_cmd_layer, container, false)
    }

    override fun onStart() {
        super.onStart()
        hideCmd("")
    }

    fun hideCmd(gameMode: String){

        if(gameMode == "brawl") {
            // Kotlin List
            var cmdViewList = listOf("cmdDmgP1", "cmdDmgP2", "cmdDmgP3", "cmdDmgP4")

            // Kotline for each, it == list-element
            cmdViewList.forEach {
                hideCmdView = view!!.findViewWithTag(it)
                hideCmdView!!.visibility = View.GONE
            }
        }

        //tv_Cmd2 = view!!.findViewById(R.id.cmdDmgP4)
        //tv_Cmd2!!.visibility = View.INVISIBLE
    }

    fun changeLife(p_Id: String, v_Id: Int) {

        when (p_Id.substring(0, 3)) {
            "gai" -> {
                tv_lifeTotal = activity!!.findViewById(v_Id)
                curLife = tv_lifeTotal!!.text.toString()
                newLiTl = Integer.parseInt(curLife!!) + 1
                tv_lifeTotal!!.text = newLiTl!!.toString()
            }
            "cmd" -> {
                tv_lifeTotal = activity!!.findViewById(v_Id)
                curLife = tv_lifeTotal!!.text.toString()
                newLiTl = Integer.parseInt(curLife!!) - 1
                tv_lifeTotal!!.text = newLiTl!!.toString()

                tv_Cmd = view!!.findViewWithTag(p_Id)
                curCmd = tv_Cmd!!.text.toString()
                if (curCmd!!.length == 7) {
                    tv_Cmd!!.text = "1 " + curCmd!!
                } else {
                    val cmdDmg = curCmd!!.split(" ")[0]
                    val newCmd = Integer.parseInt(cmdDmg) + 1
                    tv_Cmd!!.text = "$newCmd CMD-DMG"
                }
            }
            "dmg" -> {
                tv_lifeTotal = activity!!.findViewById(v_Id)
                curLife = tv_lifeTotal!!.text.toString()
                newLiTl = Integer.parseInt(curLife!!) - 1
                tv_lifeTotal!!.text = newLiTl!!.toString()
            }
            "inf" -> {
                tv_lifeTotal = activity!!.findViewById(v_Id)
                curLife = tv_lifeTotal!!.text.toString()
                newLiTl = Integer.parseInt(curLife!!) - 1
                tv_lifeTotal!!.text = newLiTl!!.toString()

                tv_inf = view!!.findViewWithTag(p_Id)
                curInf = tv_inf!!.text.toString()
                if (curInf!!.length == 6) {
                    tv_inf!!.text = "1 " + curInf!!
                } else {
                    val infDmg = curInf!!.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[0]
                    val newInf = Integer.parseInt(infDmg) + 1
                    tv_inf!!.text = "$newInf Infect"
                }
            }
        }
    }
}

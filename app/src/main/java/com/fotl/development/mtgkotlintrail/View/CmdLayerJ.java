package com.fotl.development.mtgkotlintrail.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.fotl.development.mtgkotlintrail.R;

public class CmdLayerJ extends Fragment {

    private TextView tv_lifeTotal;
    private String curLife;
    private Integer newLiTl;
    private TextView tv_Cmd;
    private String curCmd;
    private TextView tv_inf;
    private String curInf;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View convertView = inflater.inflate(R.layout.fragment_cmd_layer, container, false);


        return convertView;
    }

    public void changeLife(String p_Id, int v_Id){

        switch (p_Id.substring(0, 3)){
            case "gai":
                tv_lifeTotal = getActivity().findViewById(v_Id);
                curLife = tv_lifeTotal.getText().toString();
                newLiTl = Integer.parseInt(curLife) + 1;
                tv_lifeTotal.setText(newLiTl.toString());
                break;
            case "cmd":
                tv_lifeTotal = getActivity().findViewById(v_Id);
                curLife = tv_lifeTotal.getText().toString();
                newLiTl = Integer.parseInt(curLife) - 1;
                tv_lifeTotal.setText(newLiTl.toString());

                tv_Cmd = getView().findViewWithTag(p_Id);
                curCmd = tv_Cmd.getText().toString();
                if(curCmd.length() == 7){
                    tv_Cmd.setText("1 " + curCmd);
                }else{
                    String cmdDmg = curCmd.split( " ")[0];
                    Integer newCmd = Integer.parseInt(cmdDmg) + 1;
                    tv_Cmd.setText(newCmd.toString() + " CMD-DMG");
                }
                break;
            case "dmg":
                tv_lifeTotal = getActivity().findViewById(v_Id);
                curLife = tv_lifeTotal.getText().toString();
                newLiTl = Integer.parseInt(curLife) - 1;
                tv_lifeTotal.setText(newLiTl.toString());
                break;
            case "inf":
                tv_lifeTotal = getActivity().findViewById(v_Id);
                curLife = tv_lifeTotal.getText().toString();
                newLiTl = Integer.parseInt(curLife) - 1;
                tv_lifeTotal.setText(newLiTl.toString());

                tv_inf = getView().findViewWithTag(p_Id);
                curInf = tv_inf.getText().toString();
                if(curInf.length() == 6){
                    tv_inf.setText("1 " + curInf);
                }else{
                    String infDmg = curInf.split(" ")[0];
                    Integer newInf = Integer.parseInt(infDmg) + 1;
                    tv_inf.setText(newInf.toString() + " Infect");
                }
                break;
        }
    }
}

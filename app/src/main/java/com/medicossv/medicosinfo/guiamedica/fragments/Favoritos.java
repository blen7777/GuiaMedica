package com.medicossv.medicosinfo.guiamedica.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.medicossv.medicosinfo.guiamedica.R;

/**
 * Created by jose.lopez04 on 3/10/2017.
 */

public class Favoritos extends Fragment
{
    public Favoritos()
    {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.row_favoritos, container, false);
    }
}

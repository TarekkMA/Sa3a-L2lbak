package com.tmaproject.sa3al2lbak;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


  public MainFragment() {
    // Required empty public constructor
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_main, container, false);
    ButterKnife.bind(this,view);
    return view;
  }

  @OnClick(R.id.get_new_joke)
  void getJoke(){
    startActivity(new Intent(getContext(),NewJokeActivity.class));
  }
}

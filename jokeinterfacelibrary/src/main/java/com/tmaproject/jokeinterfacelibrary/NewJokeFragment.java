package com.tmaproject.jokeinterfacelibrary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.JokeSimth;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewJokeFragment extends Fragment {

  @BindView(R2.id.joke_text)TextView jokeText;

  public NewJokeFragment() {
    // Required empty public constructor

  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_new_joke, container, false);
    ButterKnife.bind(this,view);
    jokeText.setText(new JokeSimth("").getJoke().getJoke());
    return view;
  }

}

package com.tmaproject.jokeinterfacelibrary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.Joke;
import com.example.JokeSimth;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewJokeFragment extends Fragment {

  private static final String TAG = "NewJokeFragment";
  @BindView(R2.id.joke_text)TextView jokeText;
  @BindView(R2.id.loading)ProgressBar loading;

  public NewJokeFragment() {
    // Required empty public constructor

  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_new_joke, container, false);
    ButterKnife.bind(this,view);
    getNewJoke();
    return view;
  }

  @OnClick({R2.id.like,R2.id.dislike})
  void getNewJoke(){
    loading.setVisibility(View.VISIBLE);
    jokeText.setVisibility(View.INVISIBLE);
    NewJokeAsyncTask.Callback callback = new NewJokeAsyncTask.Callback() {
      @Override public void onSuccess(Joke joke) {
        loading.setVisibility(View.INVISIBLE);
        jokeText.setVisibility(View.VISIBLE);
        jokeText.setText(joke.getJoke());
      }

      @Override public void onFailed(Throwable throwable) {
        loading.setVisibility(View.INVISIBLE);
        jokeText.setVisibility(View.VISIBLE);
        Toast.makeText(getContext(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
        Log.e(TAG, "onFailed: ",throwable);
      }
    };
    new NewJokeAsyncTask().execute(new Pair<>(callback, "PUT_THE_UUID_HERE"));
  }

}

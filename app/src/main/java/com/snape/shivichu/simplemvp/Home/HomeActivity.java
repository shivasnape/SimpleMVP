package com.snape.shivichu.simplemvp.Home;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.snape.shivichu.simplemvp.R;
import com.snape.shivichu.simplemvp.utils.SimpleDividerItemDecoration;

import java.util.List;

public class HomeActivity extends AppCompatActivity implements HomeView {

    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;
    private HomePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.list);
        mRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(getResources(), R.drawable.line_divider));

        mProgressBar = findViewById(R.id.progress);
        mPresenter = new HomePresenter(this, new FindItemsInteractor());
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
        mRecyclerView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.INVISIBLE);
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setItems(List<String> items) {
        mRecyclerView.setAdapter(new HomeAdapter(items, mPresenter::onItemClicked));
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}

package com.hjianfei.mvp_example.view.mian;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.hjianfei.mvp_example.R;
import com.hjianfei.mvp_example.presenter.main.MainPresenter;
import com.hjianfei.mvp_example.presenter.main.MainPresenterImpl;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView, AdapterView.OnItemClickListener {

    private ListView listView;
    private ProgressBar progressBar;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list);
        listView.setOnItemClickListener(this);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        presenter = new MainPresenterImpl(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();

    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        listView.setVisibility(View.INVISIBLE);

    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
        listView.setVisibility(View.VISIBLE);

    }

    @Override
    public void setItem(List<String> items) {
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items));

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        presenter.onItemClicked(position);
    }
}

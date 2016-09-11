package com.example.bayar.mvpgetstarted.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bayar.mvpgetstarted.MvpApplication;
import com.example.bayar.mvpgetstarted.R;
import com.example.bayar.mvpgetstarted.presentation.UserPresenter;
import com.example.bayar.mvpgetstarted.view.UserView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class UserFragment extends Fragment implements UserView{

    @Inject
    UserPresenter presenter;

    private static final String USER_ID = "user_id";
    Unbinder unbinder;

    @BindView(R.id.et_first)
    EditText etFirst;
    @BindView(R.id.et_second)
    EditText etSecond;

    public static UserFragment newInstance() {
        return new UserFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MvpApplication) getActivity().getApplication()).getComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        presenter.setView(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.pause();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.resume();
    }

    @OnClick(R.id.btn_save) void onSave() {
        presenter.saveUser();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public int getUserId() {
        return getArguments() == null ? 0 : getArguments().getInt(USER_ID, 0);
    }

    @Override
    public void displayFirstName(String name) {
        etFirst.setText(name);
    }

    @Override
    public void displayLastName(String name) {
        etSecond.setText(name);
    }

    @Override
    public void showUserNotFoundMessage() {
        Toast.makeText(getContext(), "User not found", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showUserSavedMessage() {
        Toast.makeText(getContext(), "User saved", Toast.LENGTH_LONG).show();
    }

    @Override
    public String getFirstName() {
        return etFirst.getText().toString();
    }

    @Override
    public String getLastName() {
        return etSecond.getText().toString();
    }

    @Override
    public void showUserNameIsRequired() {
        Toast.makeText(getContext(), "User name is required", Toast.LENGTH_LONG).show();
    }

}

package com.example.myapplication4;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.example.myapplication4.util.ViewUtil;

public class MainActivity extends AppCompatActivity{
    private RadioGroup rg_login; // 声明一个单选组对象
    private RadioButton rb_password; // 声明一个单选按钮对象
    private RadioButton rb_verifycode; // 声明一个单选按钮对象
    private EditText et_phone; // 声明一个编辑框对象
    private TextView tv_password; // 声明一个文本视图对象
    private EditText et_password; // 声明一个编辑框对象
    private Button btn_forget; // 声明一个忘记密码按钮控件对象
    private Button btn_login; // 声明一个登录按钮控件对象
    private Switch Sw_remember; // 声明一个复选框对象
    private int mType = 2; // 用户类型
    private boolean bRemember = false; // 是否记住密码

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg_login = findViewById(R.id.rg_login);
        rb_password = findViewById(R.id.rb_password);
        rb_verifycode = findViewById(R.id.rb_verifycode);
        et_phone = findViewById(R.id.et_phone);
        tv_password = findViewById(R.id.tv_password);
        et_password = findViewById(R.id.et_password);
        btn_forget = findViewById(R.id.btn_forget);
        btn_login = findViewById(R.id.btn_login);
        Sw_remember = findViewById(R.id.Sw_remember);

        // 给rg_login设置单选监听器
        rg_login.setOnCheckedChangeListener(new RadioListener());
        // 给ck_remember设置勾选监听器
        Sw_remember.setOnCheckedChangeListener(new CheckListener());
        // 给et_phone添加文本变更监听器
        et_phone.addTextChangedListener(new HideTextWatcher(et_phone));
        // 给et_password添加文本变更监听器
        et_password.addTextChangedListener(new HideTextWatcher(et_password));

        initTypeSpinner();
    }

    // 初始化用户类型的下拉框
    private String[] typeArray = {"个人用户", "公司用户","18990038毛鸿鼎"};

    private void initTypeSpinner() {
        // 声明一个下拉列表的数组适配器
        ArrayAdapter<String> typeAdapter = new ArrayAdapter<String>(this,
                R.layout.item_select, typeArray);
        // 设置数组适配器的布局样式
        typeAdapter.setDropDownViewResource(R.layout.item_dropdown);
        // 从布局文件中获取名叫sp_type的下拉框
        Spinner sp_type = findViewById(R.id.sp_type);
        // 设置下拉框的标题
        sp_type.setPrompt("请选择用户类型");
        // 设置下拉框的数组适配器
        sp_type.setAdapter(typeAdapter);
        // 设置下拉框默认显示第几项
        sp_type.setSelection(mType);

        // 给下拉框设置选择监听器，一旦用户选中某一项，就触发监听器的onItemSelected方法
        sp_type.setOnItemSelectedListener(new TypeSelectedListener());
    }
    // 定义用户类型的选择监听器
    class TypeSelectedListener implements AdapterView.OnItemSelectedListener {
        // 选择事件的处理方法，其中arg2代表选择项的序号
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
            mType = arg2;
        }

        // 未选择时的处理方法，通常无需关注
        public void onNothingSelected(AdapterView<?> arg0) {
        }
    }

    // 定义登录方式的单选监听器
    private class RadioListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId == R.id.rb_password) { // 选择了密码登录
                tv_password.setText("登录密码：");
                et_password.setHint("请输入密码");
                btn_forget.setText("忘记密码");
                Sw_remember.setVisibility(View.VISIBLE);
            } else if (checkedId == R.id.rb_verifycode) { // 选择了验证码登录
                tv_password.setText("　验证码：");
                et_password.setHint("请输入验证码");
                btn_forget.setText("获取验证码");
                Sw_remember.setVisibility(View.INVISIBLE);
            }
        }
    }

    // 定义是否记住密码的勾选监听器
    private class CheckListener implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (buttonView.getId() == R.id.Sw_remember) {
                bRemember = isChecked;
            }
        }
    }

    // 定义编辑框的文本变化监听器
    private class HideTextWatcher implements TextWatcher {
        private EditText mView;
        private int mMaxLength;
        private CharSequence mStr;

        HideTextWatcher(EditText v) {
            super();
            mView = v;
            mMaxLength = ViewUtil.getMaxLength(v);
        }

        // 在编辑框的输入文本变化前触发
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        // 在编辑框的输入文本变化时触发
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mStr = s;
        }

        // 在编辑框的输入文本变化后触发
        public void afterTextChanged(Editable s) {
            if (mStr == null || mStr.length() == 0)
                return;
            // 手机号码输入达到11位，或者密码/验证码输入达到6位，都关闭输入法软键盘
            if ((mStr.length() == 11 && mMaxLength == 11) ||
                    (mStr.length() == 6 && mMaxLength == 6)) {
                ViewUtil.hideOneInputMethod(MainActivity.this, mView);
            }
        }
    }
}
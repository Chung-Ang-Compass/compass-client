package com.example.compass;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.List;



public class ChattingTabFragment extends Fragment {
    private List<Guide> guidesCopy;
    ArrayList<Guide> guides;
    private String[] countries;
    private String[] kor_cities;
    private String[] usa_cities;
    private String[] themes;

    private Spinner country_spinner;
    private Spinner city_spinner;
    private Spinner theme_spinner;

    private String selectedCountry;
    private String selectedCity;
    private String selectedTheme;
    private EditText editSearch;

    private ChattingGuideGridViewAdapter adapter;


    public ChattingTabFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View thisFragmentView = inflater.inflate(R.layout.fragment_chatting_tab, container, false);

        // 모델 업데이트.
        Communication.updateGuides();

        // 모델 가져오기.
        guides = Guides.getGuides();

        guidesCopy = new ArrayList<>();
        guides.addAll(guidesCopy);

        // 커스텀 어뎁터 생성
        adapter = new ChattingGuideGridViewAdapter(
                getContext(),
                R.layout.chatting_guide_griditem,       // GridView 항목의 레이아웃
                guidesCopy);    // 데이터

        GridView gv = (GridView)thisFragmentView.findViewById(R.id.gridView1);
        gv.setAdapter(adapter);  // 커스텀 아답타를 GridView 에 적용


        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // TODO : Post image + 제목 + 정보들 모델. <Integer>가 아닌 모델이 들어가야 함.
                Intent intent = new Intent(getActivity(), GuideInfoActivity.class);
                intent.putExtra("Guide Name", guides.get(position).getName());
                intent.putExtra("Guide Country", guides.get(position).getCountry());
                intent.putExtra("Guide City", guides.get(position).getCity());
                intent.putExtra("Guide Theme", guides.get(position).getTheme());
                startActivity(intent);
            }
        });

        countries = getResources().getStringArray(R.array.country);
        kor_cities = getResources().getStringArray(R.array.kor_city);
        usa_cities = getResources().getStringArray(R.array.usa_city);
        themes = getResources().getStringArray(R.array.theme);

        final ArrayAdapter<String> country_adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, countries);
        final ArrayAdapter<String> kor_city_adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, kor_cities);
        final ArrayAdapter<String> usa_city_adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, usa_cities);
        final ArrayAdapter<String> theme_adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_dropdown_item, themes);
        Log.v("KKT", "getView() : "+ getView());
        country_spinner = (Spinner)thisFragmentView.findViewById(R.id.country_search_spinner);
//        country_spinner.setText("국가 선택");
        country_spinner.setAdapter(country_adapter);

        city_spinner = (Spinner)thisFragmentView.findViewById(R.id.city_search_spinner);
//        city_spinner.setText("도시 선택");

        theme_spinner = (Spinner)thisFragmentView.findViewById(R.id.theme_search_spinner);
        theme_spinner.setAdapter(theme_adapter);

        guides.addAll(guidesCopy);
        adapter.notifyDataSetChanged();

        country_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id){
                selectedCountry = countries[position];
                guidesCopy.clear();

                for(int i = 0;i < guides.size(); i++)
                {
                    if(guides.get(i).getCountry().equals(selectedCountry)){
                        // 검색된 데이터를 리스트에 추가한다.
                        guidesCopy.add(guides.get(i));
                    }
                }
                // 리스트 데이터가 변경되었으므로 아답터를 갱신하여 검색된 데이터를 화면에 보여준다.
                adapter.notifyDataSetChanged();

                switch(position){
                    case 0:
                        city_spinner.setAdapter(kor_city_adapter);
                        city_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                selectedCity = kor_cities[position];

                                guidesCopy.clear();

                                for(int i = 0;i < guides.size(); i++)
                                {
                                    if(guides.get(i).getCountry().equals(selectedCountry) && guides.get(i).getCity().equals(selectedCity)){
                                        // 검색된 데이터를 리스트에 추가한다.
                                        guidesCopy.add(guides.get(i));
                                    }
                                }
                                // 리스트 데이터가 변경되었으므로 아답터를 갱신하여 검색된 데이터를 화면에 보여준다.
                                adapter.notifyDataSetChanged();

                                switch(position){
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                    default :
                                }
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                        //한국만 띄워주기 함수
                        break;
                    case 1:
                        // 중국
                        break;
                    case 2:
                        city_spinner.setAdapter(usa_city_adapter);
                        city_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                selectedCity = usa_cities[position];

                                guidesCopy.clear();

                                for(int i = 0;i < guides.size(); i++)
                                {
                                    if(guides.get(i).getCountry().equals(selectedCountry) && guides.get(i).getCity().equals(selectedCity)){
                                        // 검색된 데이터를 리스트에 추가한다.
                                        guidesCopy.add(guides.get(i));
                                    }
                                }
                                // 리스트 데이터가 변경되었으므로 아답터를 갱신하여 검색된 데이터를 화면에 보여준다.
                                adapter.notifyDataSetChanged();

                                switch(position){
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    default :
                                }
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                            }
                        });
                        // 미국
                        break;
                    case 3:
                        // 스위스
                        break;
                    default:
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView){
            }
        });


        theme_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedTheme = themes[position];

                guidesCopy.clear();

                for(int i = 0;i < guides.size(); i++)
                {
                    if(guides.get(i).getCountry().equals(selectedCountry) && guides.get(i).getCity().equals(selectedCity) && guides.get(i).getTheme().equals(selectedTheme)){
                        // 검색된 데이터를 리스트에 추가한다.
                        guidesCopy.add(guides.get(i));
                    }
                }
                // 리스트 데이터가 변경되었으므로 아답터를 갱신하여 검색된 데이터를 화면에 보여준다.
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        editSearch = thisFragmentView.findViewById(R.id.guide_search_et);

        // input창에 검색어를 입력시 "addTextChangedListener" 이벤트 리스너를 정의한다.
        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                // input창에 문자를 입력할때마다 호출된다.
                // search 메소드를 호출한다.
                String text = editSearch.getText().toString();
                searchByName(text);
            }
        });

        // Inflate the layout for this fragment
        return thisFragmentView;
    }

    // 검색을 수행하는 메소드
    public void searchByName(String charText) {

        // 문자 입력시마다 리스트를 지우고 새로 뿌려준다.
        guidesCopy.clear();

        // 문자 입력이 없을때는 모든 데이터를 보여준다.
        if (charText.length() == 0) {
            guidesCopy.addAll(guides);
        }
        // 문자 입력을 할때..
        else
        {
            // 리스트의 모든 데이터를 검색한다.
            for(int i = 0;i < guides.size(); i++)
            {
                // arraylist의 모든 데이터에 입력받은 단어(charText)가 포함되어 있으면 true를 반환한다.
                if (guides.get(i).getName().toLowerCase().contains(charText))
                {
                    if(guides.get(i).getCountry().equals(selectedCountry) && guides.get(i).getCity().equals(selectedCity) && guides.get(i).getTheme().equals(selectedTheme)){
                        // 검색된 데이터를 리스트에 추가한다.
                        guidesCopy.add(guides.get(i));
                    }
                }
            }
        }
        // 리스트 데이터가 변경되었으므로 아답터를 갱신하여 검색된 데이터를 화면에 보여준다.
        adapter.notifyDataSetChanged();
    }

}

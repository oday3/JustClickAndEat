package ps.ns.just_click_and_eat.network.asp.feature;

import android.annotation.SuppressLint;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import ps.ns.just_click_and_eat.network.asp.model.restaurants.Restaurants;
import ps.ns.just_click_and_eat.network.asp.model.IntroApp;
import ps.ns.just_click_and_eat.network.asp.model.PaginationBean;
import ps.ns.just_click_and_eat.network.asp.model.menu.Menu;
import ps.ns.just_click_and_eat.network.utils.RequestListener;
import ps.ns.just_click_and_eat.network.utils.RetrofitModel;

public class General {
    private static final String TAG_SUCCESS = "Response success";
    private static final String TAG_ERROR = "Response error";
    private static final String TAG_PARAMS = "Params";

    public General() {
    }

    private final RetrofitModel retrofitModel = new RetrofitModel();
    private Gson gson = new Gson();


    @SuppressLint("CheckResult")
    public void getAppInfo(RequestListener<ArrayList<IntroApp>> listener) {
        retrofitModel.getAppInfo().subscribe(appResponse -> {
                    Log.e(TAG_SUCCESS, appResponse.getStatus().toString() + "");
                    if (appResponse.getStatus()) {
//                        JsonReader reader = new JsonReader(new StringReader(appResponse.getResult()));
//                        reader.setLenient(true);
                        Type listType = new TypeToken<ArrayList<IntroApp>>() {
                        }.getType();
                        ArrayList<IntroApp> list = gson.fromJson(appResponse.getResult(), listType);
                        listener.onSuccess(list);

                    } else {
                        listener.onFail(appResponse.getMessage(), appResponse.getStatusCode());
                    }
                }, throwable -> {
                    listener.onFail(throwable.getMessage(), -1);
                    Log.e(TAG_ERROR, throwable.getMessage() + "");
                }
        );
    }

    @SuppressLint("CheckResult")
    public void getRestaurants( RequestListener<ArrayList<Restaurants>> listener) {
        retrofitModel.getRestaurant().subscribe(appResponse -> {
                    Log.e(TAG_SUCCESS, appResponse.getStatus().toString() + "");
                    if (appResponse.getStatus()) {
//                        JsonReader reader = new JsonReader(new StringReader(appResponse.getResult()));
//                        reader.setLenient(true);
                        PaginationBean bean = gson.fromJson(appResponse.getResult(), PaginationBean.class);
                        Type listType = new TypeToken<ArrayList<Restaurants>>() {
                        }.getType();
                        ArrayList<Restaurants> list = gson.fromJson(bean.getResult(), listType);
                        listener.onSuccess(list);
                    } else {
                        listener.onFail(appResponse.getMessage(), appResponse.getStatusCode());
                    }
                }, throwable -> {
                    listener.onFail(throwable.getMessage(), -1);
                    Log.e(TAG_ERROR, throwable.getMessage() + "");
                }
        );
    }

    @SuppressLint("CheckResult")
    public void getRestaurantsById(int id, String token, RequestListener<Restaurants> listener) {
        retrofitModel.getRestaurantById(token, id).subscribe(appResponse -> {
                    Log.e(TAG_SUCCESS, appResponse.getStatus().toString() + "");
                    if (appResponse.getStatus()) {
//                        JsonReader reader = new JsonReader(new StringReader(appResponse.getResult()));
//                        reader.setLenient(true);
                        Type listType = new TypeToken<Restaurants>() {
                        }.getType();
                        Restaurants list = gson.fromJson(appResponse.getResult(), listType);
                        listener.onSuccess(list);
                    } else {
                        listener.onFail(appResponse.getMessage(), appResponse.getStatusCode());
                    }
                }, throwable -> {
                    listener.onFail(throwable.getMessage(), -1);
                    Log.e(TAG_ERROR, throwable.getMessage() + "");
                }
        );
    }

    @SuppressLint("CheckResult")
    public void search(String params, RequestListener<ArrayList<Restaurants>> listener) {
        retrofitModel.search(params).subscribe(appResponse -> {
                    Log.e(TAG_SUCCESS, appResponse.getStatus().toString() + "");
                    if (appResponse.getStatus()) {
//                        JsonReader reader = new JsonReader(new StringReader(appResponse.getResult()));
//                        reader.setLenient(true);
                        Type listType = new TypeToken<ArrayList<Restaurants>>() {
                        }.getType();
                        ArrayList<Restaurants> list = gson.fromJson(appResponse.getResult(), listType);
                        listener.onSuccess(list);

                    } else {
                        listener.onFail(appResponse.getMessage(), appResponse.getStatusCode());
                    }
                }, throwable -> {
                    listener.onFail(throwable.getMessage(), -1);
                    Log.e(TAG_ERROR, throwable.getMessage() + "");
                }
        );
    }

    @SuppressLint("CheckResult")
    public void getMenuList(int id, RequestListener<ArrayList<Menu>> listener) {
        retrofitModel.getMenuList(id).subscribe(appResponse -> {
                    Log.e(TAG_SUCCESS, appResponse.getStatus().toString() + "");
                    if (appResponse.getStatus()) {
//                        JsonReader reader = new JsonReader(new StringReader(appResponse.getResult()));
//                        reader.setLenient(true);
                        Type listType = new TypeToken<ArrayList<Menu>>() {
                        }.getType();
                        ArrayList<Menu> list = gson.fromJson(appResponse.getResult(), listType);
                        listener.onSuccess(list);
                    } else {
                        listener.onFail(appResponse.getMessage(), appResponse.getStatusCode());
                    }
                }, throwable -> {
                    listener.onFail(throwable.getMessage(), -1);
                    Log.e(TAG_ERROR, throwable.getMessage() + "");
                }
        );
    }

}
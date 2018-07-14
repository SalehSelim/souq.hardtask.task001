package com.task001.Api;



public interface ApiResponse<T>{
        void onSuccess(T response);
        void onFailure(Throwable error);

}

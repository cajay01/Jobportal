import {REQUEST_JOB_DATA,REQUEST_JOB_DATA_SUCCESS,REQUEST_JOB_DATA_FAILED } from '../actions/index';

const initialState={
    request:{},
    success:false,
    fail:false,
    response:{}
}

export default function(state=initialState,action){
   console.log('+++++ action',action)
    switch(action.type){
       case REQUEST_JOB_DATA:
          return{...state,request:action.payload,response:{}}; 
       case REQUEST_JOB_DATA_SUCCESS:
          return{...state,request:{},response:action.payload,success:true};
       case REQUEST_JOB_DATA_FAILED:
          return{...state,request:{},response:action.payload,fail:true}
       default:
          return{...state};
    }
}
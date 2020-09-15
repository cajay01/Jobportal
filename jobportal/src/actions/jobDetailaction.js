export const REQUEST_JOB_DATA = "REQUEST_JOB_DATA";
export const REQUEST_JOB_DATA_SUCCESS="REQUEST_JOB_DATA_SUCCESS";
export const REQUEST_JOB_DATA_FAILED="REQUEST_JOB_DATA_FAILED";

export function requestJobData(data){
    return {type:REQUEST_JOB_DATA,payload:data}
}
export function requestJobDataSuccess(data){
    return { type:REQUEST_JOB_DATA_SUCCESS,payload:data}
}

export function requestJobDataFailed(data){
    return { type:REQUEST_JOB_DATA_FAILED,payload:data}
}
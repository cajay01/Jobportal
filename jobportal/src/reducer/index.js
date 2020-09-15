import {combineReducers} from 'redux';
import JobData from './reducer_JobData';

const baseReducer=combineReducers({
    jobData: JobData,
});

export default baseReducer;
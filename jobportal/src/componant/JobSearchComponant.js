import React from 'react';
import axios from 'axios';
import JobListComponant from './JobListComponant';
import {requestJobDataSuccess} from '../actions/jobDetailaction';
import { connect } from 'react-redux';

class JobSearchComponant extends React.Component {

    constructor(props){
        super(props);
        this.state={jobData:[]};

    }

    searchJob=()=>{
    
    }
 
   render(){
    const {jobData}=this.state; 
    this.props.requestJobDataSuccess(jobData);
       return(   
           <div>
              { console.log('Hi',jobData)}
               <input type='text' name='skill'/>
               <input type='text' name='location'/>
               <button onClick={this.searchJob}>Search</button>
           
               {jobData.length > 0 ? < JobListComponant />: 'No data found' }
           </div>
       );
   }
    
   componentDidMount(){

    console.log('hi');
    axios.get('http://localhost:8080/api/getAllJobRequirement')
    .then(res => {
      this.setState({
          jobData:res.data,
      })//,()=>console.log(this.state.jobData))
    });
    
   }

   componentWillUnmount(){
    
   }
 }

 function mapstateToProps(state){
  return{ jobDetail:state.jobDetail};
 }
 export default connect(mapstateToProps,{requestJobDataSuccess}) (JobSearchComponant);
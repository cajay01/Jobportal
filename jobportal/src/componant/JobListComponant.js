import React from 'react';
import axios from 'axios';
import {requestJobDataSuccess} from '../actions/jobDetailaction';
import { connect } from 'react-redux';

class JobListComponant extends React.Component {
    constructor(props){
        super(props);
        console.log(this.props);
    }

    applyJob=job=>()=>{
        console.log('hi ',job);

        axios.post('http://localhost:8080/api/submitJob',{
            job
        })
    .then(res => {
      this.setState({
          jobData:res.data,
      })//,()=>console.log(this.state.jobData))
    });
    }

    render(){
   return(
   <div>
             {this.props.jobDetail.response.map((job, index) => (
          <div key={index}>
            <p>{job.nameofcompany}</p>
            <p>{job.exp}</p>
            <p>{job.education}</p>
            <p>{job.skills}</p>
            <button onClick={this.applyJob(job)}>Apply</button>
            <br/><br/><br/><br/>
          </div>
          
        ))}
   </div>);
    }
    componentDidMount(){
       
    }
}
function mapstateToProps(state){
    return{ jobDetail:state.jobData};
   }
export default connect(mapstateToProps,{requestJobDataSuccess}) (JobListComponant);
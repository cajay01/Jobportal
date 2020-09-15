
import React from 'react';
import { Redirect } from "react-router-dom";
import { useHistory } from "react-router-dom";
import {Link,Route} from 'react-router-dom';
import JobSearch from './JobSearchComponant';
import PropTypes from 'prop-types';
class Home extends React.Component {
   static contextTypes = {
      router: PropTypes.object
    }
   
    callAbout = ()=>{
        console.log('HIIIIIII');
        this.props.history.push('/about')
        
               console.log(this.props.history);
    }
    render() {
       return (
          <div>
             <h1>Home...</h1>
             <button onClick={this.callAbout}>Click...</button>
             <JobSearch/>
          </div>
       )
    }
 }

 export default Home;
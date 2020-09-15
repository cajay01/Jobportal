import React from 'react';
import './App.css';
import {BrowserRouter,Route} from 'react-router-dom';
import Home from './componant/Home';
import About from './componant/About';
class App extends React.Component {
  render() {
     return (
        <div>
         <BrowserRouter>
         <div>
         <Route  path = "/" exact component = {Home} />
         <Route  path = "/about"  component = {About} />
         </div>
         </BrowserRouter> 
        </div>
     )
  }
}
export default App;

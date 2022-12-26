import {useState} from 'react';
import logo from './logo.svg';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';


import PlayerComponent from './components/PlayerComponent/PlayerComponent.tsx';
import CreatePlayerComponent from './components/CreatePlayerComponent/CreatePlayerComponent.tsx';



function App() {

  let [isShown, setIsShown] = useState(false);
  const handleClick = event => {
    setIsShown(current => !current);
  };
  return (
    <div className="App">
      <h1>Welcome</h1>
      <div className='row'>
        <div className='col-1'>
          <button className='btn btn-primary float-left' onClick={handleClick}>Create New Player</button>
        </div>
      </div>
      <div className='row'>
        <div className='col-12'>
          { isShown && <CreatePlayerComponent />}
          <PlayerComponent />
        </div>
      </div>
    </div>
  );

 
}




export default App;

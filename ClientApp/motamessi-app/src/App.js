import logo from './logo.svg';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';

import PlayerComponent from './components/PlayerComponent/PlayerComponent.tsx';

function App() {
  return (
    <div className="App">
      <h1>Welcom</h1>
      <PlayerComponent />
    </div>
  );
}

export default App;

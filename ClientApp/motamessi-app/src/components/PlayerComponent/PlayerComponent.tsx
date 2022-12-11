import React, { Component } from 'react';
import Table from 'react-bootstrap/Table';
import Button from 'react-bootstrap/Button';

interface SoccerPlayers{
  players:any;  
}

class PlayerComponent extends Component <{}, SoccerPlayers>
{
  constructor(props:any) {
    super(props);
    this.state = {
      players: []
    };    
  }
  componentDidMount(){
    fetch("http://localhost:54366/api/v1/players/getall")
    .then(res => res.json())
    .then(
      (res) => {  
        console.log(res);
        this.setState({
          players:res  
        });
      },
      (error) => {
        alert('error!!!!!!!!!!!! ');
      }
    );
  }
  render(): React.ReactNode {
    return (

      <Table striped bordered hover size="sm">
        <thead>
          <tr>
            <th>#</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Gender</th>
            <th>Age</th>
            <th>Cell</th>
            <th>Email</th>
            <th></th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          {this.state.players.map(player => (
            <tr key={player.id}>
              <td>{player.id}</td>
              <td>{player.first}</td>
              <td>{player.last}</td>
              <td>{player.gender}</td>
              <td>{player.age}</td>
              <td>{player.cell}</td>
              <td>{player.email}</td>
              <td><Button id="player.id" as="a" variant="danger" onClick={()=>alert('GEt stat for '+player.id)}> Show Stat </Button></td>
              <td>
              </td>
            </tr>            
          ))}        
        </tbody>
      </Table>

      
        
      )
  }
}

export default PlayerComponent;

import React, { Component, useState } from 'react';

interface myCompState{
  error:any;
  isLoaded:boolean;
  items:any;  
}
class DataComponent extends Component<{}, myCompState> {
  
  constructor(props:any) {
    super(props);
    this.state = {
      error: null,
      isLoaded: false,
      items: []
    };
    
  }
  componentDidMount() {
    fetch("http://localhost:54366/api/v1/players/getall")
      .then(res => res.json())
      .then(
        (res) => {  
          this.setState({
            error:null,
            isLoaded:true,
            items:res  
          });
        },
        (error) => {
          alert('error!!!!!!!!!!!! ');
        }
      );
  }

  render() {
    return (
      <ul>
        {this.state.items.map(item => (
          <li key={item.id}>
            {item.first} {item.last}
          </li>
        ))}
      </ul>
    );
  }
}

export default DataComponent;

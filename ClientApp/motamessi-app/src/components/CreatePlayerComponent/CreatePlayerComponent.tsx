import React, { Component } from 'react';
import Button from 'react-bootstrap/Button';



class CreatePlayerComponent extends Component <{}>
{
  constructor(props:any) {
    super(props);
  }

  render(): React.ReactNode {
    return (<div>
      <div className='row mt-3'><div className='col-4'><input className='form-control' placeholder='Enter Players Frist Name'></input></div></div>
      <div className='row mt-3'><div className='col-4'><input className='form-control' placeholder='Enter Players Last Name'></input></div></div>
      <div className='row mt-3'><div className='col-4'><input className='form-control' placeholder='Enter Players Age'></input></div></div>
      <div className='row mt-3'><div className='col-4'><input className='form-control' placeholder='Enter Players Email'></input></div></div>
      <div className='row mt-3 mb-3'><div className='col-4'><input className='form-control' placeholder='Enter Players Goal'></input></div></div>
      </div>);
  }
}
export default CreatePlayerComponent;

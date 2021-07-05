import React, { Component } from 'react';
import axios from 'axios';

class SpecificDataset extends Component {
    componentWillMount() {
        axios.get("https://iftm-clinica-veterinaria.herokuapp.com/" + this.props.endpoint + this.props.opt)
            .then((response) => {
                if(Array.isArray(response.data)) {
                    this.props.change(this.props.endpoint, response.data);
                } else {
                    let arr = [response.data];
                    this.props.change(this.props.endpoint, arr);
                }
            })
    }

    render() {
        return (
            <div>
                
            </div>
        );
    }
}

export default SpecificDataset;
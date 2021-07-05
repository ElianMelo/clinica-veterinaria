import React, { Component } from 'react';
import axios from 'axios';

class Dataset extends Component {
    componentWillMount() {
        axios.get("https://iftm-clinica-veterinaria.herokuapp.com/" + this.props.endpoint)
            .then((response) => { 
                this.props.change(this.props.endpoint, response.data);
            })
    }

    render() {
        return (
            <div>
                
            </div>
        );
    }
}

export default Dataset;
import React, { Component } from 'react';
import axios from 'axios';

class Dataset extends Component {
    constructor(props) {
        super(props);
    }

    componentWillMount() {
        axios.get("http://localhost:8080/" + this.props.endpoint)
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
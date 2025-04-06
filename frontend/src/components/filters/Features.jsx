import React from 'react';
import './Features.css';

function Features() {
    return (
        <div>
            <input className={"inputFeatures"} type={"text"} placeholder={"Minimum number of rooms"}/>
            <input className={"inputFeatures"} type={"text"} placeholder={"Minimum number of bathrooms"}/>
            <input className={"inputFeatures"} type={"text"} placeholder={"Minimum number of parking spots"}/>
            <input className={"inputFeatures"} type={"text"} placeholder={"Minimum number of garages"}/>
        </div>
    );
}

export default Features;
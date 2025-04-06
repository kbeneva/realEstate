import React from 'react';
import './Building.css';

function Building(props) {
    return (
        <div>
            <p className={"buildingText"}>Living area</p>
            <div className={"buildingContainer"}>
                <input className={"inputBuilding"} type={"text"} placeholder={"Min"}/>
                <p className={"buildingText"}>to</p>
                <input className={"inputBuilding"} type={"text"} placeholder={"Max"}/>
                <p className={"buildingText"}>sqft</p>
            </div>
            <p className={"buildingText"}>Built between</p>
            <div className={"buildingContainer"}>
                <input className={"inputBuilding"} type={"text"} placeholder={"Min"}/>
                <p className={"buildingText"}>to</p>
                <input className={"inputBuilding"} type={"text"} placeholder={"Max"}/>
            </div>
        </div>

    );
}

export default Building;
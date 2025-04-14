import React from 'react';
import './Building.css';
import {useFormContext} from 'react-hook-form';

function Building() {


    const { register } = useFormContext();

    return (
        <div className={"buildingFilters"}>
            <p className={"buildingText"}>Living area</p>
            <div className={"buildingContainer"}>
                <input className={"inputBuilding"} type={"text"} placeholder={"Min"} {...register("minArea")}/>
                <p className={"buildingText"}>to</p>
                <input className={"inputBuilding"} type={"text"} placeholder={"Max"}  {...register("maxArea")}/>
                <p className={"buildingText"}>sqft</p>
            </div>
            <p className={"buildingText"}>Built between</p>
            <div className={"buildingContainer"}>
                <input className={"inputBuilding"} type={"text"} placeholder={"Min"} {...register("minYear")}/>
                <p className={"buildingText"}>to</p>
                <input className={"inputBuilding"} type={"text"} placeholder={"Max"} {...register("maxYear")}/>
            </div>
        </div>

    );
}

export default Building;
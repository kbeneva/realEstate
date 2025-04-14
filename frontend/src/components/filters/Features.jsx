import React from 'react';
import './Features.css';
import {useFormContext} from "react-hook-form";

function Features() {

    const { register } = useFormContext();
    return (
        <div className={"FeaturesFilters"}>
            <input className={"inputFeatures"} type={"text"} placeholder={"Minimum number of rooms"}  {...register("nbRooms")}/>
            <input className={"inputFeatures"} type={"text"} placeholder={"Minimum number of bathrooms"} {...register("nbBathrooms")}/>
            <input className={"inputFeatures"} type={"text"} placeholder={"Minimum number of parking spots"} {...register("nbParking")}/>
            <input className={"inputFeatures"} type={"text"} placeholder={"Minimum number of garages"} {...register("nbGarages")}/>
        </div>
    );
}

export default Features;
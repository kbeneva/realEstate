import React, {useState, useEffect} from 'react';
import axios from 'axios';
import PropertiesListCard from "./PropertiesListCard.jsx";

function PropertiesRentListCard() {
    return (
        <div>
            <PropertiesListCard typePropriete={"Rent"} priceType={"/month"}/>
        </div>
    );
}

export default PropertiesRentListCard;

import React, {useState, useEffect} from 'react';
import axios from 'axios';
import PropertiesListCard from "./PropertiesListCard.jsx";

function PropertiesSaleListCard() {



    return (
        <div>
            <PropertiesListCard typePropriete={"Sale"} priceType={""}/>
            <PropertiesListCard typePropriete={"Rent"} priceType={"/month"} />

        </div>
    );
}

export default PropertiesSaleListCard;
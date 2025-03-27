import React, {useState, useEffect} from 'react';
import axios from 'axios';
import {data, Link} from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.css';
import Card from 'react-bootstrap/Card';
import ImagePropertyList from "./ImagePropertyList.jsx";





function PropertiesListCard() {

    const [tabProperty, setProperty] = useState([]);



    const loadAllProperty = async () => {
        const result = await axios.get("http://www.localhost:9696/propertyRent/getAllRentProperty");
        setProperty(result.data);
    };

    // const tabImagesResult = ImagePropertyList(tabProperty[0])  // le lien de l'image aura comme dernier param le id des proprete
    // console.log(tabProperty.map((data) => data.idProperty));


    useEffect(() => {
        loadAllProperty();
    }, []);



    return (

        <div id={"cardProperties"} className="row row-cols-3">

            {tabProperty.map((data) => (

                    <Card  key={data.idProperty}>

                        <ImagePropertyList idPropriete={data.idProperty}/>

                        <Card.Body>
                            <Card.Title>{data.price}$ / month</Card.Title>
                            <Card.Text>{data.address} {data.city}</Card.Text>
                            <Card.Text>{data.nbRooms} {data.nbBathrooms}</Card.Text>
                            <Card.Text></Card.Text>
                        </Card.Body>
                    </Card>
                ))}
        </div>

    );
}

export default PropertiesListCard;
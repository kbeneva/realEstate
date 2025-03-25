import React, {useState, useEffect} from 'react';
import axios from 'axios';
import {Link} from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.css';
import Card from 'react-bootstrap/Card';



function PropertiesListCard() {

    const [tabProperty, setProperty] = useState([]);


    const loadAllProperty = async () => {
        const result = await axios.get("http://www.localhost:9696/propertyRent/getAllRentProperty");
        setProperty(result.data);
    };


    useEffect(() => {
        loadAllProperty();
    }, []);


    return (

        <div >
            {tabProperty.map((data) => (
                    <Card  key={data.idProperty} style={{ width: '18rem' }}>
                        <Card.Img variant="top" src="..." />
                        <Card.Body>
                            <Card.Title>{data.price} / month</Card.Title>
                            <Card.Text>{data.address}</Card.Text>
                            <Card.Text>{data.city}</Card.Text>
                            <Card.Text>{data.nbRooms}</Card.Text>
                            <Card.Text>{data.nbBathrooms}</Card.Text>
                        </Card.Body>
                    </Card>
                ))}
        </div>

    );
}

export default PropertiesListCard;
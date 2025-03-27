import React, {useState, useEffect} from 'react';
import axios from 'axios';
import {data, Link} from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.css';
import Card from 'react-bootstrap/Card';
import ImagePropertyList from "./ImagePropertyList.jsx";





function PropertiesListCard(props) {

    const [tabProperty, setProperty] = useState([]);



    const loadAllProperty = async () => {
        const result = await axios.get(`http://www.localhost:9696/property${props.typePropriete}/getAllProperty`);
        setProperty(result.data);
    };




    useEffect(() => {
        loadAllProperty();
    }, []);



    return (



        <div id={"cardProperties"} className="row row-cols-3">

            {tabProperty.map((data) => (

                    <Card  key={data.idProperty}>

                        <ImagePropertyList idPropriete={data.idProperty} typeProprety={props.typePropriete}/>

                        <Card.Body>
                            <Card.Title>{data.price}{props.priceType}</Card.Title>
                            <Card.Text>
                                <div>{data.address}</div>
                                <div>{data.city}</div>
                            </Card.Text>

                            <Card.Text>
                                <div>{data.nbRooms}</div>
                                <div>{data.nbBathrooms}</div>
                            </Card.Text>
                        </Card.Body>
                    </Card>
                ))}
        </div>

    );
}

export default PropertiesListCard;
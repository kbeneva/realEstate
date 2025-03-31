import React, {useState, useEffect} from 'react';
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.css';
import Card from 'react-bootstrap/Card';
import ImagePropertyList from "./ImagePropertyList.jsx";
import {data, Link} from "react-router-dom";
import { FaBed } from "react-icons/fa";
import { FaShower } from "react-icons/fa";
import { FaLocationDot } from "react-icons/fa6";





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


        <div id={"cardProperties"}>

            {tabProperty.map((data) => (

                <Card key={data.idProperty}>

                    <ImagePropertyList idPropriete={data.idProperty} typeProprety={props.typePropriete}/>

                    <Card.Body>
                        <Card.Title>{data.price.toLocaleString("fr-CA", {
                            style: "currency",
                            currency: "CAD"
                        })}{props.priceType}</Card.Title>

                        <div >
                        <Card.Text style={{display: "inline-flex", fontSize:"16px"}}>
                            <div> <FaLocationDot /> {data.address},</div>
                            <div style={{paddingInline:"5px"}}>{data.city}</div>
                        </Card.Text>

                        </div>

                        <div>
                        <Card.Text style={{display: "inline-flex"}}>
                            <div><FaBed />{data.nbRooms}</div>
                            <div style={{paddingInline:"10px"}}> <FaShower />{data.nbBathrooms}</div>
                        </Card.Text>

                        </div>

                    </Card.Body>
                </Card>
            ))}
        </div>


    );


}

export default PropertiesListCard;
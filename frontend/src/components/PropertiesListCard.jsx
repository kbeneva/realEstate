import React, {useState, useEffect} from 'react';
import axios from 'axios';
import {data, Link} from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.css';
import Card from 'react-bootstrap/Card';
import ImagePropertyList from "./ImagePropertyList.jsx";
import {FaLocationDot} from "react-icons/fa6";
import {FaBed} from "react-icons/fa";
import {FaBath} from "react-icons/fa";
import { CiHeart } from "react-icons/ci";


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

                    <div className={"carouselHolder"}>
                        <ImagePropertyList idPropriete={data.idProperty} typeProprety={props.typePropriete}/>

                    </div>

                    <Card.Body>
                        <div>
                            <Card.Title style={{display: "inline-flex"}}>{data.price.toLocaleString("fr-ca", {
                                style: "currency",
                                currency: "CAD"
                            })}

                                <div style={{fontSize:"15px",alignContent:"end"}}>
                                    {props.priceType}
                                </div>
                                {/*fonctionnalité à voir*/}
                                {/*<div  style={{}}>*/}
                                {/*    <CiHeart size={40} id='heart' className='button'/>*/}
                                {/*</div>*/}
                            </Card.Title>

                        </div>

                        <Card.Text style={{paddingTop: "10px",}}>
                            <div><FaLocationDot/> {data.address},</div>
                            <div style={{paddingLeft: "3px"}}> {data.city}</div>

                        </Card.Text>
                        <div>
                            <Card.Text style={{display: "inline-flex"}}>
                                <div><FaBed size={23} style={{marginRight: "0.5rem"}}/>{data.nbRooms}</div>
                                <div style={{paddingInlineStart: "1rem"}}><FaBath size={22} style={{marginRight: "0.5rem"}}/>{data.nbBathrooms}
                                </div>
                            </Card.Text>
                        </div>

                    </Card.Body>
                </Card>
            ))}
        </div>

    );
}

export default PropertiesListCard;
import React, {useEffect, useState} from 'react';
import axios from "axios";
import Card from "react-bootstrap/Card";
import {v4 as uuidv4} from 'uuid';
import ImagePropertyList from "./propertiesDisplay/ImagePropertyList.jsx";
import "./clientRequestList.css"


function ClientRequestList() {

    const [tabRequests, setRequests] = useState([]);
    const user = JSON.parse(localStorage.getItem("user"));

    const data = [
        `http://localhost:9696/RequestRent/customer/${user.idUser}`,
        `http://localhost:9696/RequestSale/customer/${user.idUser}`,
    ];

    const loadRequests = async () => {
        try {
            const results = await Promise.all(data.map(url => axios.get(url)));
            const allRequests = [...results[1].data, ...results[0].data]
            setRequests(allRequests)

        } catch (error) {
            console.error(error)
        }


    }
    useEffect(() => {
        loadRequests();
    }, []);

    console.log(tabRequests)


    return (
        <div>

            <div className={"cardRequests"}>

                {tabRequests.map((data) => (

                    <Card key={uuidv4()}>

                        <Card.Body className={"requestContent"}>

                            <div className={"agentRequestHolder"}>
                                <div className={"agentContainer"}>
                                    <div className={"pfp"}>
                                        <img src={"/pfp.jpg"} alt={"agent pfp"}/>
                                    </div>

                                    <div className={"agentDetails"}>
                                        <div className={"nameAgent"}><p>
                                            {data.agent.fname}</p>
                                            <p>{data.agent.lname}</p>
                                        </div>
                                        <p> {data.agent.email}</p>
                                        <p> {data.agent.phone}</p>
                                    </div>
                                </div>
                            </div>

                            <div>
                                <div> {data.description}</div>
                                <div> {data.creationDate}</div>
                                <div> {data.statusDemande}</div>

                            </div>

                            <div className={"carouselHolder"}>
                                <ImagePropertyList idPropriete={data[`property${data.typeDemande}`]?.idProperty}
                                                   typeProprety={data.typeDemande}/>
                            </div>


                        </Card.Body>


                    </Card>

                ))}

            </div>

        </div>
    );
}

export default ClientRequestList;
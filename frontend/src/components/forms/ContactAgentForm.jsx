import React, {useEffect, useState} from 'react';
import "./contactAgent.css"
import Box from "@mui/material/Box";
import {useParams} from "react-router-dom";
import axios from "axios";


function ContactAgentForm() {
    const {id, typeProperty} = useParams()
    const [property, setProperty] = useState({});


    const loadProperty = async () => {
        try {
            const result = await axios.get(`http://localhost:9696/property${typeProperty}/${id}`);
            setProperty(result.data);


        } catch (error) {
            console.error("property not found")
        }

    }

    useEffect(() => {
        loadProperty();
    }, []);

    if (!property.agent) {  /// méthode toLocaleString est appelé avant les données
        return <div>loading property</div>
    }


    return (
        <div>


            <Box className={"formAgent"}>
                <h2>Contact agent</h2>
                <div className={"clientSection"}>


                    <div className={"section3"}>
                        <div>
                            <label htmlFor={"Description"}>Description</label>
                            <textarea className={"desc"} placeholder="Write more details for the agent.."></textarea>
                        </div>

                    </div>

                    <button type={"submit"} value={"Submit"}>submit</button>


                </div>
                <div className={"agentSection"}>

                    <div className={"agentContainer"}>
                        <div className={"pfp"}>
                            <img src={"/pfp.jpg"} alt={"agent pfp"}/>
                        </div>


                        <div className={"agentDetails"}>
                            <div className={"nameAgent"}><p>
                                {property.agent.fname}</p>
                                <p>{property.agent.lname}</p>
                            </div>
                            <p> {property.agent.email}</p>
                            <p> {property.agent.phone}</p>

                        </div>

                    </div>
                </div>

            </Box>

        </div>
    );
}

export default ContactAgentForm;
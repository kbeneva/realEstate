import React from 'react';
import "./contactAgent.css"
import {FormProvider} from "react-hook-form";

function ContactAgentForm() {
    return (
        <div>


            <h1>Contact agent</h1>


            <div className={"FormAgent"}>

                <div className={"clientSection"}>
                    <FormProvider>

                    </FormProvider>
                </div>
                <div className={"agentSection"}></div>

            </div>

        </div>
    );
}

export default ContactAgentForm;
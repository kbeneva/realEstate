import React from 'react';
import './Category.css';

function PropertyType() {
    return (
        <div>
            <div className={"categoryContainer"}>
                <label className={"categoryLabel"}>
                    <input className={"categoryCheckbox"} type={"checkbox"}/>
                    House
                </label>
                <label className={"categoryLabel"}>
                    <input className={"categoryCheckbox"} type={"checkbox"}/>
                    Condo
                </label>
            </div>
            <div className={"categoryContainer"}>
                <label className={"categoryLabel"}>
                    <input className={"categoryCheckbox"} type={"checkbox"}/>
                    Farm / Chalet
                </label>
                <label className={"categoryLabel"}>
                    <input className={"categoryCheckbox"} type={"checkbox"}/>
                    Terrain
                </label>
            </div>
        </div>

    )
        ;
}

export default PropertyType;
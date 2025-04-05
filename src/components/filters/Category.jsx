import React from 'react';
import './Category.css';

function Category() {
    return (
        <div className={"categoryContainer"}>
            <label className={"categoryLabel"}>
                <input className={"categoryCheckbox"} type={"checkbox"}/>
                To buy
            </label>
            <label className={"categoryLabel"}>
                <input className={"categoryCheckbox"} type={"checkbox"}/>
                To rent
            </label>
        </div>
    );
}

export default Category;
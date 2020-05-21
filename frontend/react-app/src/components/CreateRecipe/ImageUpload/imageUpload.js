import React, {Component} from 'react';

export class ImageUpload extends Component {
    constructor(props) {
        super(props);
    }

    handleUploadFile = (event) => {
        const data = new FormData();
        //using File API to get chosen file
        let file = event.target.files[0];
        console.log("Uploading file", event.target.files[0]);
        data.append('file', event.target.files[0]);
        data.append('name', 'my_file');
        data.append('description', 'this file is uploaded by young padawan');
        let self = this;
        //calling async Promise and handling response or error situation
    };

    render() {
        return (
            <div>
                <input type="file" onChange={this.handleUploadFile}/>
            </div>
        )
    };
}

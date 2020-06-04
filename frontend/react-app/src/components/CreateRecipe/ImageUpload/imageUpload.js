import React, {Component} from 'react';

export class ImageUpload extends Component {
    constructor(props) {
        super(props);
    }
    state = {
        selectedFile: null,
    }

    onFileUploadHandler = (e) => {
        this.setState({
            selectedFile: e.target.files[0]
        }, () =>
        this.props.onFileUploadHandler(this.state.selectedFile))
    };

    render() {
        return (
            <div class="input-group">
                <div className="custom-file">
                    <input type="file" name="file" onChange={this.onFileUploadHandler} className="custom-file-input" id="inputGroupFile01"
                           aria-describedby="inputGroupFileAddon01" />
                        <label className="custom-file-label" htmlFor="inputGroupFile01">Choose file</label>
                </div>
            </div>

        )
    };
}

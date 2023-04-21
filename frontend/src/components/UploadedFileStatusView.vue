<template>

    <v-data-table
        :headers="headers"
        :items="uploadedFileStatus"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'UploadedFileStatusView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "fileSize", value: "fileSize" },
                { text: "fileName", value: "fileName" },
                { text: "isIndexed", value: "isIndexed" },
                { text: "videoUrl", value: "videoUrl" },
                { text: "isUploaded", value: "isUploaded" },
            ],
            uploadedFileStatus : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/uploadedFileStatuses'))

            temp.data._embedded.uploadedFileStatuses.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.uploadedFileStatus = temp.data._embedded.uploadedFileStatuses;
        },
        methods: {
        }
    }
</script>


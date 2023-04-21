
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import FileManager from "./components/listers/FileCards"
import FileDetail from "./components/listers/FileDetail"

import IndexManager from "./components/listers/IndexCards"
import IndexDetail from "./components/listers/IndexDetail"

import VideoProcessManager from "./components/listers/VideoProcessCards"
import VideoProcessDetail from "./components/listers/VideoProcessDetail"




export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/files',
                name: 'FileManager',
                component: FileManager
            },
            {
                path: '/files/:id',
                name: 'FileDetail',
                component: FileDetail
            },

            {
                path: '/indices',
                name: 'IndexManager',
                component: IndexManager
            },
            {
                path: '/indices/:id',
                name: 'IndexDetail',
                component: IndexDetail
            },

            {
                path: '/videoProcesses',
                name: 'VideoProcessManager',
                component: VideoProcessManager
            },
            {
                path: '/videoProcesses/:id',
                name: 'VideoProcessDetail',
                component: VideoProcessDetail
            },





    ]
})
